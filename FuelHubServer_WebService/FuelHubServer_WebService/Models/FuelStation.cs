using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace fuelWebAPI.Models{
    [BsonIgnoreExtraElements]
    public class FuelStation{
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string StationId{get;set;} = String.Empty;

        [BsonElement("stname")]
        public string StationName{get;set;} = String.Empty;

        [BsonElement("lorries")]
        public int Lorries{get;set;}

        [BsonElement("buses")]
        public int Buses{get;set;}

        [BsonElement("cars")]
        public int Cars{get;set;}

        [BsonElement("vans")]
        public int Vans{get;set;}

        [BsonElement("bikes")]
        public int Bikes{get;set;}

        [BsonElement("taxis")]
        public int Taxis{get;set;}

        [BsonElement("waittime")]
        public double WaitTime{get;set;}

    }
}