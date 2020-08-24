/**This file gets data from reviews.json and shows them in a carouse
 * movement at the index page of Escape Holiday PArk
 * Created by Rhea VIllafuerte
 */

var ReviewCarousel = function() {
    "use strict";
    var reviewList, reviewIndex;
    var pub = {};



    function Review(title, author, reviewcontent) {
        this.title = title;
        this.author = author;
        this.reviewcontent = reviewcontent;

        this.makeHTML = function () {

            return "<strong>" + this.title + "</strong><br> By: " + this.author + "</br><br> Comment: " + this.reviewcontent + "</br>";
        };
    }

    function nextImage() {
        $("#reviews").find("p").html(reviewList[reviewIndex].makeHTML());
        reviewIndex += 1;
        if (reviewIndex === reviewList.length) {
            reviewIndex = 0;
        }
    }

    pub.setup = function() {

        reviewList = [];
        $.ajax({
            type: "GET",
            url: "json/reviews.json",
            success: function(data) {
                for(var i in data){
                    if(data.hasOwnProperty(i)) {
                        reviewList.push(new Review(data[i].title, data[i].author, data[i].reviewcontent));

                    }
                }
                reviewIndex = 0;
                nextImage();
                setInterval(nextImage, 7000);



            }

        });





    };

    return pub;

}();

$(document).ready(ReviewCarousel.setup);


