import axios from "axios";

// GET List Car
export function getListCar(callback, errorCallback) {
  axios
    .get("http://localhost:8080/api/cars")
    .then((res) => {
      if (callback != null) {
        callback(res.data);
      }
    })
    .catch((err) => {
      if (errorCallback != null) {
        errorCallback(err.message);
      }
    });
}

// GET Car Detail
export function getCarDetail(idCar, callback, errorCallback) {
  axios
    .get("http://localhost:8080/api/cars/" + idCar)
    .then((res) => {
      if (callback != null) {
        callback(res.data);
      }
    })
    .catch((err) => {
      if (errorCallback != null) {
        errorCallback(err.message);
      }
    });
}

// GET Search By Keyword
export function getSearchByKeyword(keyword, callback, errorCallback) {
  axios
    .get(`http://localhost:8080/api/cars?keyword=${keyword}`)
    .then((res) => {
      if (callback != null) {
        callback(res.data);
      }
    })
    .catch((err) => {
      if (errorCallback != null) {
        errorCallback(err.message);
      }
    });
}

// GET Search By Price Range
export function getSearchByPriceRange(min, max, callback, errorCallback) {
  axios
    .get(`http://localhost:8080/api/cars?min=${min}&max=${max}`)
    .then((res) => {
      if (callback != null) {
        callback(res.data);
      }
    })
    .catch((err) => {
      if (errorCallback != null) {
        errorCallback(err.message);
      }
    });
}
