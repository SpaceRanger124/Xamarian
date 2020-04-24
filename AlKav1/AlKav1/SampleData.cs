using AlKav1.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AlKav1
{
    public class SampleData
    {
        public static void Initialize(Models.AppContext context)
        {
            if (!context.Confectionery.Any())
            {
                context.Confectionery.AddRange(
                    new Confectionery
                    {
                        Name = "Candy",
                        Producer = "Spartak",
                        ShelfLife = 2,
                        Price = 600
                    },
                    new Confectionery
                    {
                        Name = "Super Candy",
                        Producer = "Spartak",
                        ShelfLife = 2,
                        Price = 600
                    },
                    new Confectionery
                    {
                        Name = "Wafer",
                        Producer = "Kommunarka",
                        ShelfLife = 3,
                        Price = 400
                    },
                    new Confectionery
                    {
                        Name = "Extra Wafer",
                        Producer = "Kommunarka",
                        ShelfLife = 4,
                        Price = 400
                    },
                    new Confectionery
                    {
                        Name = "Green Candy",
                        Producer = "Kommunarka",
                        ShelfLife = 4,
                        Price = 200
                    },
                    new Confectionery
                    {
                        Name = "Choc",
                        Producer = "Roshen",
                        ShelfLife = 4,
                        Price = 500
                    },
                    new Confectionery
                    {
                        Name = "White Choc",
                        Producer = "Roshen",
                        ShelfLife = 4,
                        Price = 700
                    }
                );
                context.SaveChanges();
            }
        }
    }
}
