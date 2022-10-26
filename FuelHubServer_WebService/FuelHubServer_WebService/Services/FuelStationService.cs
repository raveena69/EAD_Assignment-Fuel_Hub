using fuelWebAPI.Models;
using MongoDB.Driver;

namespace fuelWebAPI.Services
{
    public class FuelStationService: IFuelStationService { 

        private readonly IMongoCollection<FuelStation> _fuelStation;

        public FuelStationService(IFuelStationDBSettings settings, IMongoClient mongoClient){
            var database = mongoClient.GetDatabase(settings.DatabaseName);
            _fuelStation = database.GetCollection<FuelStation>("fuelStation");
        }

        public FuelStation Create(FuelStation fuelStation){
            _fuelStation.InsertOne(fuelStation);
            return fuelStation;
        }

        public List<FuelStation> Get(){
            return _fuelStation.Find(fuelStation => true).ToList();
        }

        public FuelStation Get(string id){
             return _fuelStation.Find(fuelStation => fuelStation.StationId == id).FirstOrDefault();
        }

        public void Update(string id, FuelStation fuelStation){
            _fuelStation.ReplaceOne(fuelStation => fuelStation.StationId == id, fuelStation);
        }

        public void Remove(string id){
            _fuelStation.DeleteOne(fuelStation => fuelStation.StationId == id);
        }
    }
}