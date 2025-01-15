const { stringify } = require("querystring");
const {
  createDairy,
  findManyDiaries,
} = require("../repository/dairyRepository");

async function saveDairy(dairy) {
  console.log(dairy);
  await createDairy(dairy);
}

async function findDiaries() {
  const diaries = await findManyDiaries();
  return diaries;
}

module.exports = { saveDairy, findDiaries };
