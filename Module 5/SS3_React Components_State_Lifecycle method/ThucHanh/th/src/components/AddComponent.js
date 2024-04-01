// Xây dựng Class component
// import { Component } from 'react';
// class AddComponent extends Component {
//     render() {
//         return <h1>Total: {this.props.firstNumber + this.props.secondNumber}</h1>
//     }
// }
// export default AddComponent;


// Xây dựng Function component
function AddComponent(props) {
    return (
        <h1>Total: {props.firstNumber + props.secondNumber}</h1>
    );
}

export default AddComponent;