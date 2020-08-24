/**
 * Carousel to move each campsite type with pictures at interval of time.
 * Created by Rhea VIllafuerte adapted from Carousel of Classic Cinema
 */
var Carousel = function() {
    "use strict";
    var imageList, imageIndex;
    var pub = {};

    function nextImage() {
        $("#carousel").html(imageList[imageIndex].makeHTML());
        imageIndex += 1;
        if (imageIndex === imageList.length) {
            imageIndex = 0;
        }
    }

    function Campsite( image,description) {


        this.image = image;
       this.description = description;


        this.makeHTML = function () {
            return "<figure><img src='" + this.image + "' alt = 'campsites'><figcaption></figcaption></a><br><b>"+ this.description +"</b></figure>";
        };
    }

    pub.setup = function() {
        $.ajax({
            type: "GET",
            url: "json/galleryDisplayOnly.json",
            success: function (data) {
                imageList = [];
                var campsite = data.campSites.site;


                for (var i in campsite) {
                    if (campsite.hasOwnProperty(i)) {

                        imageList.push(new Campsite(campsite[i].image, campsite[i].description));

                    }
                }
                imageIndex = 0;
                nextImage();
                setInterval(nextImage, 5000);
            }
        });
    };
    return pub;

}();

$(document).ready(Carousel.setup);
