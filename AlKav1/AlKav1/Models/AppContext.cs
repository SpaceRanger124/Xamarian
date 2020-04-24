using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AlKav1.Models
{
    public class AppContext : DbContext
    {
        public DbSet<Confectionery> Confectionery { get; set; }
        public DbSet<Order> Order { get; set; }

        public AppContext(DbContextOptions<AppContext> options)
            : base(options)
        {
            Database.EnsureCreated();
        }
    }
}
