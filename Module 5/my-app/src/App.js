import React from 'react';
import './App.css';
class App extends React.Component{
render() {
  let i = 1;
  var j = 1;
  return(
      <div>Hello
        <h1 class="myCSS">Ha u</h1>

        <p>Result : {1 + 1}</p>

        <h5>{i === 1 ? 'true' : 'false'}</h5>

        <h5 class="myStyle">{j === 1 ? 'true' : 'false'}</h5>


      </div>
  );
}
}

export default App;
