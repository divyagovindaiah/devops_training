const express= require('express')
const app= express()
const fs= require('fs');
const { resourceLimits } = require('worker_threads');

const port = 8080;

app.listen(port, () => {
  console.log(`Example app listening at http://localhost${port}`)
});
app.get('/foo', function(req, res) {
    // res.send('Hello World')
   const data =  fs.readFileSync('telemetry.json', 'utf-8')
   res.send(data)
    
});

app.use(express.urlencoded({
  extended: true
}));
 


