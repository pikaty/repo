$(document).ready(function () {

    $('#nav li').hover(
        function () {
            $('ul', this).stop().slideDown(250);

        },
        function () {
            $('ul', this).stop().slideUp(200);
        }
    );

});