var missed = {
    'kinley': "kinti kim lee kienle kinizsi",
    'cappy': "happy 2 kettő",
    'nestea': "ness ikea tea",
    'naturaqua': "natúr aqua víz",
    'aloe': "alul",
    'vadmálna': "vad málna",
    'őszibarack': "őszi barack",
    'multivitamin': "multi vitamin",
    'bodzavirág': "bodza virág",
    'citromfű': "citrom fű",
    'buborékmentes': "mentes sima csendes",
    'szénsavas': "csípős pezsgő buborékos bubi bubis",
    'feketeribizli': "ribizli",
    'emotion': "motion",
    'rebarbara': "barbi barbie",
    'mangó': "mango",
    'light': "lajt lejt",
    'chili': "csili",
    'pulpy': "pult pálfi puppy púp party parti ulti árpi hp ápisz",
    'grapefruit': "grépfrút",
    'eper': "eperfa fr",
    'coca': "kuka kula",
    'cola': "kula",
    'zero': "zéró"
};

var products = [
  "Coca cola",
  "Coca cola light",
  "Coca cola zero",
  "Coca cola cherry",
  "Fanta citrom",
  "Fanta narancs",
  "Fanta zero narancs",
  "Fanta vadmálna",
  "Fanta bodza",
  "Sprite",
  "Kinley gyömbér",
  "Kinley tonik",
  "Kinley bitter lemon",
  "Lift szőlő",
  "Lift meggy",
  "Lift citrom",
  "Lift narancs",
  "Nestea fekete citrom",
  "Nestea fekete őszibarack",
  "Nestea fekete Bodza szőlő",
  "Nestea zöld eper",
  "Nestea zöld Aloe vera",
  "Cappy narancs",
  "Cappy alma",
  "Cappy körte",
  "Cappy ananász",
  "Cappy eper",
  "Cappy multivitamin",
  "Cappy őszibarack",
  "Cappy paradicsom",
  "Cappy kajszibarack",
  "Cappy Pulpy narancs",
  "Cappy Pulpy alma",
  "Cappy Pulpy grapefruit",
  "Cappy Pulpy őszibarack",
  "Cappy Ice Fruit Multivitamin mangosztán",
  "Cappy Ice Fruit Alma körte bodzavirág",
  "Cappy Ice Fruit Red berry hibiszkus",
  "Cappy Ice Fruit Őszibarack dinnye citromfű",
  "Cappy Ice Fruit Narancs Mix kaktusz",
  "Cappy Ice Fruit Grapefruit passionfruit zöld tea",
  "NaturAqua buborékmentes",
  "NaturAqua enyhe",
  "NaturAqua szénsavas",
  "NaturAqua Emotion egres feketeribizli",
  "NaturAqua Emotion körte citromfű",
  "NaturAqua Emotion szeder lime",
  "NaturAqua Emotion málna kókusz",
  "NaturAqua Emotion mangó chili",
  "NaturAqua Emotion eper rebarbara",
  "NaturAqua Emotion őszibarack hibiszkusz"
];

productsDiv.innerHTML = products.join(', ');

var Words = function() {
    var found = 0.6;
    var notFound = 0.1;

    var productProbability = [];
    var words = [];
    var productIndex = [];

    var initProbability = function() {
	productProbability = [];
	var prob = 1.0 / products.length;
	products.forEach(function() {
	    productProbability.push(prob);
	})
    };

    var initWords = function() {
	words = [];
	productIndex = [];
	

	products.forEach(function(product, index) {
	    product = product.toLowerCase();
	    var w = product.split(' ');
	    var l = w.length;
	    for (var i = 0; i < l; i++) {
		var word = w[i];
		if (missed[word]) {
		    w = w.concat(missed[word].split(' '));
		}
	    };

	    w.forEach(function(word) {
		var wordIndex = words.indexOf(word);

		if (wordIndex === -1) {
			words.push(word);
			wordIndex = productIndex.push([]) - 1;
		};

		productIndex[wordIndex].push(index);
    	    });
	});
    };

    var listWords = function() {
	words.forEach(function(word, index) {
	    var ps = [];
	    productIndex[index].forEach(function(pIndex) {
		ps.push(products[pIndex]);
	    });
	    console.log(word + " => " + ps.join(','));
	});
    }

    var normalize = function() {
	var sum = 0.0;

	productProbability.forEach(function(p) {
	    sum += p;
	});

	var l = productProbability.length;

	for ( var i = 0; i < l; i++) {
	    productProbability[i] /=  sum;
	}
    }

    var tuneProbabilities = function(wordIndex) {
	var indexes = productIndex[wordIndex];

	for (var i = 0; i < productProbability.length; i++) {
		productProbability[i] *= ((indexes.indexOf(i) !== -1) ? found : notFound);
	}

	normalize();
    };

    var checkWord = function(word) {
        word = word.toLowerCase();
	word.split(' ').forEach(function(word) {
	    var index = words.indexOf(word);
    	    if (index !== -1) {
		tuneProbabilities(index);
		console.log(word + " exists among words");
	    }
	    else {
		console.log(word + " is unknown");
	    }
	});
    }

    var getClues = function(limit) {
	if (!limit) {
	    limit = 0.2;
	};

	var pp = [].concat(productProbability);
	pp.sort(function(a, b){return b-a});
	var first = pp[0];
	var second = pp[1];
	var ps = [];
	productProbability.forEach(function(p, index) {
	    if (((first > (second * 3)) && p === first) || (p > pp[2])){
		ps.push((products[index]).split('|')[0]);
	    };
	});

	if (ps.length === 1) {
	    initProbability();
	}

	return ps;
    }

    initProbability();
    initWords();

    console.log(words);
    console.log(productProbability);
    listWords();

    return {
	'restart' 	: initProbability,
	'checkWord'	: checkWord,
	'getClues'	: getClues
    }


}

var words = Words();

function newTranscriptResult(word) {
    words.checkWord(word);
    console.log("clues:", words.getClues());
}
