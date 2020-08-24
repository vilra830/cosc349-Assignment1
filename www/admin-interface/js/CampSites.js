/**
 * @desc A closure that manages the display of campsites
 * @requires JQuery
 * @author Nick Meek
 * @created July 2019
 * @updated July 2019
 */
var CampSites = (function () {
    "use strict";
    var pub = {};
    var items;

    pub.setup = function () {
        var outStr = "";

        //get the campsites information and build the list for display / selection
        $.when($.getJSON("./json/campsites.json", function (data) {
                items = data.campSites.site;
                $.each(items, function (key, value) {
                    $("#accommTypeLst").append("<li id='" + value.number + "'>" + value.number + " : " +
                        value.siteType + " : " +
                        value.pricePerNight + "<input type='radio' name='campSite' value='" + value.number + "'> </li>");
                });
            })
        ).done(function () {
            //Add the event handlers to the list items just created
            $("#accommTypeLst li").mouseenter(function () {
                $("#sitePreview").text("");
                showPreview($(this).attr("id"));
                $(this).css({cursor: "pointer"});
            }).mouseleave(function () {
                //nothing yet
            });
        });
    };//setup

    /**
     * Coordinates the building and displaying of a preview of each site
     * @param id The id of the site
     */
    function showPreview(id) {
        var site;
        site = findSiteById(id);
        if (site) {
            $("#sitePreview").append(makeInfoTag(site));
        } else {
            $("#sitePreview").text("No Preview Found");
        }
    }//showPeview

    /**
     * Returns an html definition list describing a particular site
     * @param site The site object
     * @return {string} The html string
     */
    function makeInfoTag(site) {
        return "<section id='siteInfo'>" +
            "<dl><dt>ID:</dt><dd>" + site.number + "</dd></dl>" +
            "<dl><dt>Price:</dt><dd>" + site.pricePerNight + "</dd></dl>" +
            "<dl><dt>Description:</dt><dd>" + site.description + "</dd></dl>" +
            makeImgTag(site.siteType) + "</section>";

    }

    /**
     * Returns an html img tag for a particular 'type' of site
     * @param type Currently on of 'Tent', 'Cabin' or 'Van'. The default is 'Tent'
     * @return {string} The html tag.
     */
    function makeImgTag(type) {
        if (type === "Tent") {
            return "<img src='./images/tent.jpg' alt='A tent site'>";
        } else if (type === "Cabin") {
            return "<img src='./images/cabin1.jpg' alt='A Cabin'>";
        } else if (type === "Van") {
            return "<img src='./images/rv.jpg' alt='A Camper Van'>";
        } else {
            return "<img src='./images/tent.jpg' alt='A tent site'>";
        }
    }

    /**
     * Returns the site with the given id or null if not found
     * @param id The id of the site
     * @return {*} The site or null
     */
    function findSiteById(id) {
        var s = null;
        $.each(items, function (k, v) {
            if (parseInt(id) === parseInt(v.number)) {
                s = items[k];
                return false;
            }
        });
        return s;
    }//findSiteById

    return pub;
}());

$(document).ready(CampSites.setup);
