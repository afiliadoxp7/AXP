var pageNumber = 0;
// efeito infinte scroll


$(window).scroll(function() {

	var scrollTop = $(this).scrollTop();
	var conteudo = $(document).height() - $(window).height();

	//console.log('scrollTop: ', scrollTop, ' | ', 'conteudo', conteudo);

	if (scrollTop >= conteudo) {

		pageNumber++;
		setTimeout(function() {
			loadByScrollBar(pageNumber);
		}, 220);
	}

});

function loadByScrollBar(pageNumber) {

	$.ajax({
		method: "GET",
		url: "/exibirProdutosVenda/ajax",
		data: {
			page: pageNumber
		},
		success: function(response, status, xhr) {
			//console.log("resposta: ", response);

			$(".row").fadeIn(300, function() {
				$(this).append(response)
			});

		}
	})

};

document.querySelector('p').addEventListener('touchstart',f);
document.querySelector('p').addEventListener('touchend',f);
document.querySelector('p').addEventListener('touchmove',f);

function f(eventos){
	console.log( eventos.touches, eventos.type );
}









