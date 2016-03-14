var products = [
  "Coca cola",
  "Coca cola light",
  "Coca cola zero",
  "Coca cola cherry",
  "Fanta citrom",
  "Fanta narancs",
  "Fanta zero narancs",
  "Fanta vadmálna vad málna",
  "Fanta bodza",
  "Sprite",
  "Kinley gyömbér",
  "Kinley tonik",
  "Kinley bitter lemon",
  "Lift szőlő",
  "Lift meggy",
  "Lift citrom",
  "Lift narancs",
  "Nestea nes tea fekete citrom",
  "Nestea fekete őszibarack őszi barack",
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

var words = [];
for (var p = 0; p < products.length; p++) {
    var w = products[p].split(' ');
    w.forEach(function(word) {
	word = word.toLowerCase();
      if (words.indexOf(word)  === -1) {
        words.push(word);
      }
  });
};

console.log(words);

function newTranscriptResult(word) {
    word = word.toLowerCase();
    var words_ = word.split(' ');
    for (var i = 0; i < words_.length; i++) {
	word = words_[i];
        if (words.indexOf(word) !== -1) {
	    console.log(word + "exists among words");
	}
	else {
	    console.log(word + " is unknown");
	}
    }
}