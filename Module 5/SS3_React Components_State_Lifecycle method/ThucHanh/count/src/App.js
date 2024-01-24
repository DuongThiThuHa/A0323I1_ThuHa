import {Component} from "react";
import './App.css'
class App extends Component{
    constructor(props) {
        //Kế thừa thuộc tính có từ lớp cha
        super(props);
        // Khởi tạo trạng thái ban đầu của thành phần, với thuộc tính number có giá trị là 0.
        this.state = {
            number:0
        };
    }

    // Phương thức setState trong React được sử dụng để cập nhật trạng thái của một thành phần.
    increase = () => {
        this.setState({number: this.state.number + 1});
    };

    decrease = () => {
        this.setState({number:this.state.num-1});
    };

    render() {
        return(
            <div>
                <button onClick={this.decrease}>Decrease</button>
                <span>{this.state.number}</span>
                <button onClick={this.increase}>Increase</button>
            </div>
        );
    }
}
export default App;