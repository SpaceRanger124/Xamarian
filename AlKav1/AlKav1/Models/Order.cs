﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AlKav1.Models
{
    public class Order
    {
        public int OrderId { get; set; }
        public string User { get; set; }
        public string Address { get; set; }

        public int ConfectioneryId { get; set; }
        public Confectionery Confectionery { get; set; }
    }
}
