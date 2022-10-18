using MongoDB.Bson;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FuelHubServer_WebService.Models
{
    public class FuelType
    {
        public ObjectId Id { get; set; }
        public int FuelTypeId { get; set; }
        public string FuelTypeName { get; set; }
        public string FuelTypeArrivalTime { get; set; }
        public string FuelTypeArrivalDate { get; set; }
        public string FuelTypeFinishTime { get; set; }
        public string FuelTypeFinishDate { get; set; }

    }
}
