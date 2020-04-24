#pragma checksum "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "5ac139ea2559549258bb3d61276b4d0e18c27773"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Home_Catalog), @"mvc.1.0.view", @"/Views/Home/Catalog.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\_ViewImports.cshtml"
using AlKav2;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\_ViewImports.cshtml"
using AlKav2.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"5ac139ea2559549258bb3d61276b4d0e18c27773", @"/Views/Home/Catalog.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"ed04374cedffe3636fc9f94166eb0ad03aa621c0", @"/Views/_ViewImports.cshtml")]
    public class Views_Home_Catalog : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<AlKav2.Models.Confectionery>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("style", new global::Microsoft.AspNetCore.Html.HtmlString("background:#dc9696;color:#000000"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper;
        private global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
  
    Layout = null;

#line default
#line hidden
#nullable disable
            WriteLiteral("<!DOCTYPE html>\r\n\r\n<html>\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("head", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "5ac139ea2559549258bb3d61276b4d0e18c277733959", async() => {
                WriteLiteral("\r\n    <title>Confectionary sale</title>\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.HeadTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_HeadTagHelper);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("body", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "5ac139ea2559549258bb3d61276b4d0e18c277734966", async() => {
                WriteLiteral("\r\n    <h3>Board</h3>\r\n    <table>\r\n        <tr>\r\n            <td><b>Type</b></td>\r\n            <td><b>Producer</b></td>\r\n            <td><b>Image</b></td>\r\n            <td><b>Shelf life</b></td>\r\n            <td><b>Price</b></td>\r\n        </tr>\r\n");
#nullable restore
#line 21 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
         foreach (var confectionery in Model)
        {

#line default
#line hidden
#nullable disable
                WriteLiteral("            <tr>\r\n                <td>");
#nullable restore
#line 24 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
               Write(confectionery.Name);

#line default
#line hidden
#nullable disable
                WriteLiteral("&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n                <td>");
#nullable restore
#line 25 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
               Write(confectionery.Producer);

#line default
#line hidden
#nullable disable
                WriteLiteral("&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n                <td><img width=\"50\" height=\"50\"");
                BeginWriteAttribute("src", " src=\"", 719, "\"", 745, 1);
#nullable restore
#line 26 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
WriteAttributeValue("", 725, confectionery.Image, 725, 20, false);

#line default
#line hidden
#nullable disable
                EndWriteAttribute();
                WriteLiteral(" /></td>\r\n                <td>");
#nullable restore
#line 27 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
               Write(confectionery.ShelfLife);

#line default
#line hidden
#nullable disable
                WriteLiteral("&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n                <td>");
#nullable restore
#line 28 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
               Write(confectionery.Price);

#line default
#line hidden
#nullable disable
                WriteLiteral("&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n                <td>");
                __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "5ac139ea2559549258bb3d61276b4d0e18c277737356", async() => {
                    WriteLiteral("Buy");
                }
                );
                __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.UrlResolutionTagHelper>();
                __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_UrlResolutionTagHelper);
                BeginAddHtmlAttributeValues(__tagHelperExecutionContext, "href", 2, global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
                AddHtmlAttributeValue("", 931, "~/Home/Buy/", 931, 11, true);
#nullable restore
#line 29 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
AddHtmlAttributeValue("", 942, confectionery.Id, 942, 17, false);

#line default
#line hidden
#nullable disable
                EndAddHtmlAttributeValues(__tagHelperExecutionContext);
                await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
                if (!__tagHelperExecutionContext.Output.IsContentModified)
                {
                    await __tagHelperExecutionContext.SetOutputContentAsync();
                }
                Write(__tagHelperExecutionContext.Output);
                __tagHelperExecutionContext = __tagHelperScopeManager.End();
                WriteLiteral("</td>\r\n            </tr>\r\n");
#nullable restore
#line 31 "C:\Users\AKavalchuk\source\repos\AlKav2\AlKav2\Views\Home\Catalog.cshtml"
        }

#line default
#line hidden
#nullable disable
                WriteLiteral("    </table>\r\n");
            }
            );
            __Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.Razor.TagHelpers.BodyTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_Razor_TagHelpers_BodyTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_0);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n</html>");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<AlKav2.Models.Confectionery>> Html { get; private set; }
    }
}
#pragma warning restore 1591
