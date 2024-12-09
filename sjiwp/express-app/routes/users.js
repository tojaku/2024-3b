var express = require('express');
var router = express.Router();
var db = require("../services/db");
var bcrypt = require("bcrypt");

const signupSchema = require("../schemas/signup");

router.get('/', function (req, res, next) {
  res.send('respond with a resource');
});

router.get("/signup", function (req, res, next) {
  res.render("users/signup");
});

router.post("/signup", async function (req, res, next) {
  const result = signupSchema.validate(req.body);

  if (result.error) {
    res.render("users/signup", { error: true });
    return;
  }

  let conn;
  try {
    conn = await db.getConnection();
    const query = "INSERT INTO users (name, email, password_hash) VALUES (?, ?, ?);";
    const stmt = await conn.prepare(query);
    const hashedPassword = await bcrypt.hash(req.body.password, 10);
    const result = await stmt.execute([req.body.name, req.body.email, hashedPassword]);
    console.log(result);

    res.redirect("/users/signup");
  } catch (error) {
    console.log(error);

  } finally {
    conn.release();
  }



});

module.exports = router;
