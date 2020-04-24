using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AlKav1.Models
{
    public class Confectionery
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Producer { get; set; }
        public int ShelfLife { get; set; }
        public int Price { get; set; }
    }
}
