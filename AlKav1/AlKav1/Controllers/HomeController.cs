using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using AlKav1.Models;

namespace AlKav1.Controllers
{
    public class HomeController : Controller
    {
        Models.AppContext db;
        public HomeController(Models.AppContext context)
        {
            db = context;
        }
        public IActionResult Index()
        {
            return View(db.Confectionery.ToList());
        }

        [HttpGet]
        public IActionResult Buy(int? id)
        {
            if (id == null) return RedirectToAction("Index");
            ViewBag.ConfectioneryId = id;
            return View();
        }
        [HttpPost]
        public string Buy(Order order)
        {
            db.Order.Add(order);
            // сохраняем в бд все изменения
            db.SaveChanges();
            return "Thanks, " + order.User + ", for shopping!";
        }
    }
}
