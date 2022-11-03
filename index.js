const express= require('express')
const app= express()
const fs= require('fs');

const port = 8080;

app.listen(port, () => {
  console.log(`Example app listening at http://localhost${port}`)
});
app.get('/read', function(req, res) {
   const data =  fs.readFileSync('telemetry.json', 'utf-8')
   res.send(data)
    
});

app.use(express.urlencoded({
  extended: true
}));
 


