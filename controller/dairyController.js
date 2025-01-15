const express = require("express");
const { saveDairy, findDiaries } = require("../service/dairyService");

const route = express.Router();

route.get("/dairy/list", async (req, res) => {
  const diaries = await findDiaries();
  console.log("diarios que vieram da service " + JSON.stringify(diaries));
  res.status(200).json(diaries);
});

route.post("/dairy/create", async (req, res) => {
  const body = req.body;
  console.log(req.body);
  await saveDairy(req.body);
  res.status(200).json({
    name: body.name,
    idade: body.idade,
  });
});

module.exports = route;
