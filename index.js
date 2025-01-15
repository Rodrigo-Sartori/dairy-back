const express = require("express");
const dairyController = require("./controller/dairyController");
const port = process.env.PORT || 8080;

const app = express();
app.use(express.json());
app.use("/", dairyController);

app.listen(port, () => {
  console.log("aplicação iniciada");
});
