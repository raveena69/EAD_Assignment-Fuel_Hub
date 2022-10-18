using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using MongoDB.Driver;
using System.Linq;
using FuelHubServer_WebService.Models;

namespace FuelHubServer_WebService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class FuelTypeController : ControllerBase
    {
        private readonly IConfiguration _configuration;
        public FuelTypeController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public JsonResult Get()
        {
            MongoClient dbClient = new MongoClient(_configuration.GetConnectionString("FuelTypeAppCon"));

            var dbList = dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").AsQueryable();

            return new JsonResult(dbList);
        }

        [HttpPost]
        public JsonResult Post(FuelType fuelType)
        {
            MongoClient dbClient = new MongoClient(_configuration.GetConnectionString("FuelTypeAppCon"));

            int LastFuelTypeId = dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").AsQueryable().Count();
            fuelType.FuelTypeId = LastFuelTypeId + 1;

            dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").InsertOne(fuelType);

            return new JsonResult("Added Successfully");
        }

        [HttpPut]
        public JsonResult Put(FuelType fuelType)
        {
            MongoClient dbClient = new MongoClient(_configuration.GetConnectionString("FuelTypeAppCon"));

            //var filter = Builders<FuelType>.Filter.Eq("FuelTypeId", id);
            //var filterObjectId = Builders<FuelType>.Filter.Eq("FuelTypeId", fuelType.Id);
            //var filterFuelTypeId = Builders<FuelType>.Filter.Eq("FuelTypeId", fuelType.FuelTypeId);

            var filter = Builders<FuelType>.Filter.Eq("FuelTypeId", fuelType.FuelTypeId);

            //var update = Builders<FuelType>.Update.Set("FuelTypeName", fuelType.FuelTypeName);

            //var updateFuelTypeId = Builders<FuelType>.Update.Set("FuelTypeId", fuelType.FuelTypeId);
            var updateFuelTypeName = Builders<FuelType>.Update.Set("FuelTypeName", fuelType.FuelTypeName);
            var updateFuelTypeArrivalTime = Builders<FuelType>.Update.Set("FuelTypeArrivalTime", fuelType.FuelTypeArrivalTime);
            var updateFuelTypeArrivalDate = Builders<FuelType>.Update.Set("FuelTypeArrivalDate", fuelType.FuelTypeArrivalDate);
            var updateFuelTypeFinishTime = Builders<FuelType>.Update.Set("FuelTypeFinishTime", fuelType.FuelTypeFinishTime);
            var updateFuelTypeFinishDate = Builders<FuelType>.Update.Set("FuelTypeFinishDate", fuelType.FuelTypeFinishDate);

            //dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateOne(filter, updateFuelTypeId);
            //dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateOne(filter, updateFuelTypeName);
            //dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateOne(filter, updateFuelTypeArrivalTime);
            //dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateOne(filter, updateFuelTypeArrivalDate);
            //dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateOne(filter, updateFuelTypeFinishTime);
            //dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateOne(filter, updateFuelTypeFinishDate);
            //dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateMany(filter, updateFuelTypeId, updateFuelTypeName, updateFuelTypeArrivalTime, updateFuelTypeArrivalDate, updateFuelTypeFinishTime, updateFuelTypeFinishDate);

            dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateMany(filter, updateFuelTypeName);
            dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateMany(filter, updateFuelTypeArrivalTime);
            dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateMany(filter, updateFuelTypeArrivalDate);
            dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateMany(filter, updateFuelTypeFinishTime);
            dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").UpdateMany(filter, updateFuelTypeFinishDate);

            return new JsonResult("Updated Successfully");
        }


        [HttpDelete("{id}")]
        public JsonResult Delete(int id)
        {
            MongoClient dbClient = new MongoClient(_configuration.GetConnectionString("FuelTypeAppCon"));

            var filter = Builders<FuelType>.Filter.Eq("FuelTypeId", id);


            dbClient.GetDatabase("testdb").GetCollection<FuelType>("FuelType").DeleteOne(filter);

            return new JsonResult("Deleted Successfully");
        }



    }
}
