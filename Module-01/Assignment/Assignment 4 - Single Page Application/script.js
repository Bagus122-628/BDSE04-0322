var default_content = "";

$(document).ready(function () {
  checkURL();
  $("ul li a").click(function (e) {
    checkURL(this.hash);
  });
  default_content = $("#pageContent").html();
  setInterval("checkURL()", 250);
});

var lasturl = "";

function checkURL(hash) {
  if (!hash) hash = window.location.hash;

  if (hash != lasturl) {
    lasturl = hash;
    if (hash == "") $("#pageContent").html(default_content);
    else {
      if (hash == "#products") {
        loadProducts();
      } else {
        loadPage(hash);
      }
    }
  }
}

function loadPage(url) {
  url = url.replace("#", "");

  $("#loading").css("visibility", "visible");

  $.ajax({
    type: "POST",
    url: "load_page.jsp",
    data: "page=" + url,
    dataType: "html",
    success: function (msg) {
      if (parseInt(msg) != 0) {
        $("#pageContent").html(msg);
        $("#loading").css("visibility", "hidden");
      }
    },
  });
}

const jsonURL = "products.json";

function loadProducts() {
  $("#loading").css("visibility", "visible");

  $.getJSON(jsonURL, function (json) {
    let imgList = '<ul class="products">';
    $.each(json.products, function () {
      imgList += `<li>
                    <img src="${this.imgPath}">
                    <h3>${this.name}</h3>
                    <h3>
                      <span class="currency_code">SGD</span> 
                      <span class="price">${this.price}</span>
                    </h3>
                  </li>`;
    });
    imgList += "</ul>";
    $("#pageContent").html(imgList);
  });

  $("#loading").css("visibility", "hidden");
}

// Conversion
$(document).ready(function () {
  $("#select").on("change", function () {
    if (this.value === "SGD") {
      loadSingapore();
    } else if (this.value === "MYR") {
      loadMalaysia();
    } else if (this.value === "INR") {
      loadIndia();
    } else if (this.value === "PHP") {
      loadPhilippine();
    } else {
      loadIndonesia();
    }
  });
});

const prices = document.getElementsByClassName("price");
const currencyCode = document.getElementsByClassName("currency_code");
const currencyURL = "currency.json";

// Singapore
function loadSingapore() {
  loadProducts();
  $.getJSON(currencyURL, function (data) {
    const conversion = data.currencies[0].conversion;
    $.each(prices, function (index, data) {
      const textContent = parseFloat(data.textContent);
      const converted = (conversion * textContent).toFixed(2);
      data.textContent = converted.toString();
    });
    $.each(currencyCode, function (index, data) {
      data.textContent = "SGD";
    });
  });
}

// Malaysia
function loadMalaysia() {
  loadProducts();
  $.getJSON(currencyURL, function (data) {
    const conversion = data.currencies[1].conversion;
    $.each(prices, function (index, data) {
      const textContent = parseFloat(data.textContent);
      const converted = (conversion * textContent).toFixed(2);
      data.textContent = converted.toString();
    });
    $.each(currencyCode, function (index, data) {
      data.textContent = "MYR";
    });
  });
}

// India
function loadIndia() {
  loadProducts();
  $.getJSON(currencyURL, function (data) {
    const conversion = data.currencies[2].conversion;
    $.each(prices, function (index, data) {
      const textContent = parseFloat(data.textContent);
      const converted = (conversion * textContent).toFixed(2);
      data.textContent = converted.toString();
    });
    $.each(currencyCode, function (index, data) {
      data.textContent = "INR";
    });
  });
}

// Philippine
function loadPhilippine() {
  loadProducts();
  $.getJSON(currencyURL, function (data) {
    const conversion = data.currencies[3].conversion;
    $.each(prices, function (index, data) {
      const textContent = parseFloat(data.textContent);
      const converted = (conversion * textContent).toFixed(2);
      data.textContent = converted.toString();
    });
    $.each(currencyCode, function (index, data) {
      data.textContent = "PHP";
    });
  });
}

// Indonesia
function loadIndonesia() {
  loadProducts();
  $.getJSON(currencyURL, function (data) {
    const conversion = data.currencies[4].conversion;
    $.each(prices, function (index, data) {
      const textContent = parseFloat(data.textContent);
      const converted = (conversion * textContent).toFixed(2);
      data.textContent = converted.toString();
    });
    $.each(currencyCode, function (index, data) {
      data.textContent = "IDR";
    });
  });
}
