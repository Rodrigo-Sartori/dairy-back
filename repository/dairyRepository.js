const { PrismaClient } = require("@prisma/client");
const dayjs = require("dayjs");

const prisma = new PrismaClient();

async function createUser(params) {}

async function createDairy(dairy) {
  try {
    console.log(dairy);
    const newDairy = await prisma.dairy.create({
      data: {
        content: dairy.content,
        createdAt: new Date(dayjs()),
        dairyDate: new Date(dayjs()),
      },
    });
  } catch (error) {
    return error;
  }
}

async function findManyDiaries() {
  try {
    let diaries = await prisma.dairy.findMany();
    return diaries;
  } catch (error) {
    return error;
  }
}

module.exports = { prisma, createDairy, findManyDiaries };
