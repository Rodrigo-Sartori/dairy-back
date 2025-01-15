const express = require("express");
const dairyController = require("./controller/dairyController");

const app = express();
app.use(express.json());
app.use("/", dairyController);

app.listen(8080, () => {
  console.log("aplicação iniciada");
});
