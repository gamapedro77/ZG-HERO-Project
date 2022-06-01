// const axios = require("axios").default;

class AxiosRequest {
  URL: String;
  constructor(URL: String) {
    this.URL = URL;
  }

  post(data: Object) {
    const result = axios.post(URL, Object).then((response: any) => {
      return response.status;
    });
    return result;
  }

  get() {
    return [{}];
  }
}
