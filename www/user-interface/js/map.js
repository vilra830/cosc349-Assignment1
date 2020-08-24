/**
 * Created by Rhea VIllafuerte
 * Allows user to see the attractions, restaurants close to the campsite.
 * Also allows them to hide or show restaurants or attractions using the layer icon
 * at the top right corner of the map.
 */
/* global L */
var Location = (function () {
    "use strict" ;
    var map;
    var pub = {};

    // Get GeoJSON data and create features.


    pub.setup = function() {



        map = L.map('map').setView([-45.901406, 170.502113], 13);
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
            {
                maxZoom: 18,
                attribution: 'Map data &copy; ' +
                    '<a href="http://www.openstreetmap.org/copyright">' +
                    'OpenStreetMap contributors</a> CC-BY-SA'
            }).addTo(map);

        var restaurants = L.layerGroup().addTo(map);
        var attractions = L.layerGroup().addTo(map);
        var resto = L.icon({
            iconUrl: 'images/resto.png',
            iconSize:     [38, 38], // size of the icon
            iconAnchor:   [22, 22], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -26] // point from which the popup should open relative to the iconAnchor
        });

        var site = L.icon({
            iconUrl: 'images/site.png',
            iconSize:     [38, 38], // size of the icon
            iconAnchor:   [22, 22], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -26] // point from which the popup should open relative to the iconAnchor
        });

        var camp = L.icon({
            iconUrl: 'images/camp.png',
            iconSize:     [38, 38], // size of the icon
            iconAnchor:   [22, 22], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -26] // point from which the popup should open relative to the iconAnchor
        });





        $.getJSON("./json/POI.geojson" , function (data){

            L.geoJson(data, {

                onEachFeature: function(feature, marker) {

                    var lat = feature.geometry.coordinates[1];
                    var lng = feature.geometry.coordinates[0];
                    var popupContent;

                    var name = feature.properties.name;
                    var type = feature.properties.type;

                    switch (feature.properties.type) {
                        case "restaurant":
                            marker = L.marker([lat, lng], {icon: resto}).addTo(restaurants);
                            popupContent = "<b>" + name+ "</b><br> " + type;

                            break;

                        case "attraction":
                            marker = L.marker([lat, lng], {icon: site}).addTo(attractions);
                            popupContent = "<b>" + name+ "</b><br> " + type;

                            break;
                        default:
                            marker = L.marker([lat, lng], {icon: camp}).addTo(map);
                            popupContent = "<b>" + name+ "</b><br> " + type;


                    }

                    marker.bindPopup(popupContent);
                }

            });
        });


        L.control.layers({}, {

            "Restaurants":restaurants,
            "Attractions": attractions



        }).addTo(map);
    };


// Expose the public interface
    return pub;
}());

$(document).ready(Location.setup);