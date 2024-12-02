var express = require('express');
var router = express.Router();

const signupSchema = require("../schemas/signup");

router.get('/', function (req, res, next) {
  res.send('respond with a resource');
});

router.get("/signup", function (req, res, next) {
  res.render("users/signup");
});

router.post("/signup", function (req, res, next) {
  const result = signupSchema.validate(req.body);

  if (result.error) {
    let firstError = result.error.details[0];
    let errorField = firstError.context.label;
    res.render("users/signup", { error: errorField });
    return;
  }

  res.redirect("/users/signup");
});

module.exports = router;
