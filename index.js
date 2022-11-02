const express= require('express')
const app= express()

const port = 3000;

app.listen(port, () => {
  console.log('Example app listening at http://localhost:3000')
});
app.get('/foo', function(req, res) {
    res.send('Hello World')
});

app.use(express.urlencoded({
  extended: true
}));
 

