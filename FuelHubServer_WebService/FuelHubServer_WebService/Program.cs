using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FuelHubServer_WebService
{
	var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.Configure<FuelStationDBSettings>(
    builder.Configuration.GetSection(nameof(FuelStationDBSettings)));

builder.Services.AddSingleton<IFuelStationDBSettings>(sp =>
sp.GetRequiredService<IOptions<FuelStationDBSettings>>().Value);

builder.Services.AddSingleton<IMongoClient>(s => 
new MongoClient(builder.Configuration.GetValue<string>("FuelStationDBSettings:ConnectionString")));

builder.Services.AddScoped<IFuelStationService, FuelStationService>();
builder.Services.AddScoped<IFuelQueueService, FuelQueueService>();

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

    public class Program
    {
        public static void Main(string[] args)
        {
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}
