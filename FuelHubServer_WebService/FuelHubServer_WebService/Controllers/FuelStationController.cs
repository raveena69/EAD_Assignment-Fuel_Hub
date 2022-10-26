using Microsoft.AspNetCore.Mvc;
using fuelWebAPI.Services;
using fuelWebAPI.Models;

namespace fuelWebAPI.Controllers{

[Route("api/[controller]")]
[ApiController]
public class FuelStationController : ControllerBase
{
    private readonly IFuelStationService fuelService;
    public FuelStationController(IFuelStationService fuelStationService){
        this.fuelService = fuelStationService;
    }
    [HttpGet]
    public ActionResult<List<FuelStation>> Get()
    {
        return fuelService.Get();
    }

    [HttpGet("{id}")]
    public ActionResult<FuelStation> Get(string id)
    {
        var fuelStation = fuelService.Get(id);
        
        if(fuelStation == null){
            return NotFound($"Fuel Station with Id = {id} not found");
        }

        return fuelStation;
    }

    [HttpPost]
    public ActionResult<FuelStation> Post([FromBody] FuelStation fuelStation)
    {
        fuelService.Create(fuelStation);

        return CreatedAtAction(nameof(Get), new {id = fuelStation.StationId},fuelStation);
    }

    [HttpPut("{id}")]
    public ActionResult Put(string id, FuelStation fuelStation)
    {
        var fuelStationExist = fuelService.Get(id);
        
        if(fuelStationExist == null){
            return NotFound($"Fuel Station with Id = {id} not found");
        }

        fuelService.Update(id, fuelStation);

        return NoContent();
    }

    [HttpDelete]
    public ActionResult Delete(string id)
    {
        var fuelStationExist = fuelService.Get(id);
        
        if(fuelStationExist == null){
            return NotFound($"Fuel Station with Id = {id} not found");
        }

        fuelService.Remove(fuelStationExist.StationId);

        return Ok($"Fuel Station with Id = {id} deleted");
    }
}
}