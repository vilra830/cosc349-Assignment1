/**
 * @desc A closure that manages bookings.
 * @requires JQuery
 * @author Nick Meek
 * @created July 2019
 * @updated July 2019
 */
var CampBooking = (function () {
    "use strict";
    var pub = {};
    var bookings; //existing bookings

    /**
     * A function to start the various procedures that are involved in
     * ensuring only valid dates are chosen
     */
    function showAvailable() {
        $("#dateErrors").empty();
        var arriveDate = $("#arriveDatepicker");
        var departDate = $("#departDatepicker");

        checkDates();
        disableDateClash(arriveDate, departDate);
    }

    /**
     * Checks dates for basic problems.
     * Put error messages in place as necessary
     */
    function checkDates() {
        if ($("#departDatepicker").datepicker('getDate') < $("#arriveDatepicker").datepicker('getDate')) {
            $("#dateErrors").append("<p>You must arrive before you depart</p>");
        }
        if ($("#departDatepicker").val() === "" || $("#arriveDatepicker").val() === "") {
            $("#dateErrors").append("<p>You must select both arrive and depart dates</p>");
        }
        if ($("#arriveDatepicker").datepicker('getDate') < new Date()) {
            $("#dateErrors").append("<p>We only accept bookings in the future</p>");
        }
    }


    /**
     * Disables sites that are already booked for the chosen dates.
     * @param arrive The arrival date
     * @param depart The departure date
     */
    function disableDateClash(arrive, depart) {
        var existingBookingCheckin, existingBookingCheckout;

        //reset the inputs to selectable etc
        $("#accommTypeLst li").css("background-color", 'inherit');
        $("#accommTypeLst input").attr("disabled", false);

        //check the proposed booking against all current bookings
        $.each(bookings, function (k, v) {
            existingBookingCheckin = new Date(v.checkin.year, v.checkin.month - 1, v.checkin.day);//-1 cos months start at 0
            existingBookingCheckout = new Date(v.checkout.year, v.checkout.month - 1, v.checkout.day);

            //see if there is a clash with a particular previous booking
            //disable checkbox if there is a clash
            if (arrive.datepicker('getDate') >= existingBookingCheckin && arrive.datepicker('getDate') < existingBookingCheckout ||
                depart.datepicker('getDate') > existingBookingCheckin && depart.datepicker('getDate') <= existingBookingCheckout) {
                $("#" + v.number).css('background-color', 'gray');
                $("#" + v.number + " input").prop("checked", false);
                $("#" + v.number + " input").attr("disabled", true);
            }
        });
    }

    /**
     * Returns true if all information is entered, false otherwise.
     * @return {boolean}
     */
    function validateBookingInformation() {
        var selectionMade = false;

        $("#dateErrors").empty();
        if ($("#guestName").val() === "") {
            $("#dateErrors").append("<p>We need your name please</p>");
            return false;
        }

        $('input[name="campSite"]').each(function () {
            if ($(this).prop("checked") === true) {
                selectionMade = true;
            }
        });

        if (!selectionMade) {
            $("#dateErrors").append("<p>You need to select a site</p>");
            return false;
        }
        return selectionMade;
    }


    pub.setup = function () {
        //set up the jQueryUI datepickers and event handling
        var today = new Date();
        $("#checkAvail").click(showAvailable);
        $("#arriveDatepicker").datepicker().datepicker('setDate', today).mouseleave(showAvailable);
        $("#departDatepicker").datepicker().datepicker('setDate', new Date(today.getTime() + 86400000)).mouseleave(showAvailable);


        $("#makeBooking").mouseover(showAvailable);

        //get the data for the existing bookings and assign to global
        $.getJSON("json/bookings.json", function (data) {
            bookings = data.bookings.booking;
        });
    };


    return pub;
}());

$(document).ready(CampBooking.setup);