$("#search_form").submit(function (event) {
    event.preventDefault();
    console.log("zdes")
    $.ajax({
        url: "/podcasts",
        type: "POST",
        data: JSON.stringify({
            "title" : $("#inputSearch").val(),
            "category" : $('option:selected').val()
        }),
        dataType: "json",
        contentType: "application/json",
        encoding: "UTF-8",
        success: function (data) {
            $('#results').html('');
            data.forEach(function (podcast) {

                img = "/img?name=" + podcast['img'];
                track = "/track?name=" + podcast['track'];

                $('#results').append($('<div class="card container m-3">' +
                    '                        <div class="row">' +

                    // '                            <div class="col-lg-3 p-0">' +
                    // '                                <img class="card-img-top img-fluid" src="' + img + '" alt="Image of podcast">' +
                    // '                            </div>' +

                    '                            <div class="col-lg-9">' +
                    '                                <div class="card-body">' +
                    '                                    <h2 class="card-text podcast-title title">' + podcast['title'] + '</h2>' +
                    '                                    <h3 class="card-text podcast-title category">Category: <span>' + podcast['category']['name'] + '</span></h3>' +
                    '                               ' +
                    ' </div>' +
                    // '                                <div class="card-body">' +
                    // '                                    <p class="card-text">' + podcast['user']['nickname'] + '</p>' +
                    // '                                    <div class="container-audio">' +
                    // '                                        <audio controls preload="auto" id="audio">' +
                    // '                                            <source src="' + track + '" type="audio/ogg">' +
                    // '                                            Your browser dose not Support the audio Tag' +
                    // '                                        </audio>' +
                    // '                                    </div>' +
                    // '                                </div>' +
                    // '                            </div>' +
                    // '                        </div>' +

                    '                    </div>'))
            });
        }
    });
});