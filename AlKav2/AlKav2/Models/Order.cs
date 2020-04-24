using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AlKav2.Models
{
    public class Order
    {
        public int OrderId { get; set; }
        public string User { get; set; }
        public string Address { get; set; }
        public string Email { get; set; }
        public string Phone { get; set; }
        public string Quantity { get; set; }
        public string Price { get; set; }
        public string TypeOfPayment { get; set; }
        public int ConfectioneryId { get; set; }
        public Confectionery Confectionery { get; set; }
    }
}
