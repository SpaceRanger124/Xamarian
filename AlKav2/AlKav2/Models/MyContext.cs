using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AlKav2.Models
{
    public class MyContext : DbContext
    {
        public DbSet<Confectionery> Confectionery { get; set; }
        public DbSet<Order> Order { get; set; }

        public MyContext(DbContextOptions<MyContext> options)
            : base(options)
        {
            Database.EnsureCreated();
        }
    }
}
