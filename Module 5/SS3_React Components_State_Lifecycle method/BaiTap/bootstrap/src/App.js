import Home from "./Home";
import './App.css';
import {Component} from "react";

class Bootstrap extends Component {
    constructor(props) {
        super(props);
        this.state = {
            form: {email: "", password: "", isRemember: false},
            isValid: false,
            isLoggedIn: false
        };
    }

    // hàm handleChange nhận event làm param truyền vào, hàm này sẽ gọi hàm setState để cập nhật giá trị mới cho form và sau gọi hàm checkValidForm
    handleChange = (event) => {
        this.setState((state) => {
            const {form} = state
            form[event.target.name] = event.target.value
            return {form}
        }, () => this.checkValidForm())
    }

    // hàm handleChangeCheckbox, hàm này sẽ gọi hàm setState để cập nhật giá trị mới cho isRemember của form và sau gọi hàm checkValidForm
    handleChangeCheckbox = () => {
        this.setState((state) => {
            const {form} = state
            form.isRemember = !form.isRemember
            return {form}
        }, () => this.checkValidForm())
    }

    // hàm checkValidForm, hàm này sẽ kiểm tra form đã được nhập hay chưa và sau đó gọi hàm setState để cập nhật giá trị mới cho isValid
    checkValidForm = () => {
        const {email, password} = this.state.form
        const value = email && password
        this.setState({isValid: value})
    }

    // hàm handleSubmit, hàm này sẽ kiểm tra isValid đã đúng hay chưa, nếu đúng cập nhật lại giá trị mới cho isLoggedIn bằng true
    handleSubmit = () => {
        if (this.state.isValid) {
            this.setState({isLoggedIn: true})
        }
    }

    // hàm handleLogout, hàm này sẽ cập nhật lại giá trị mới cho isLoggedIn bằng false
    handleLogOut = () => {
        this.setState({isLoggedIn: false})
    }

    render() {
        const {isLoggedIn, form} = this.state
        if (isLoggedIn) return (<Home onLogOut={this.handleLogOut}></Home>)
        return (
            <div className="container d-flex align-items-center text-center">
                <div className="form-signin">
                    <form>
                        <img className="mb-4" src="https://th.bing.com/th/id/R.8e2c571ff125b3531705198a15d3103c?rik=gzhbzBpXBa%2bxMA&riu=http%3a%2f%2fpluspng.com%2fimg-png%2fuser-png-icon-big-image-png-2240.png&ehk=VeWsrun%2fvDy5QDv2Z6Xm8XnIMXyeaz2fhR3AgxlvxAc%3d&risl=&pid=ImgRaw&r=0" alt="" width="60" height="60"/>
                            <h1 className="h3 mb-3 fw-normal">Please sign in</h1>
                            <div className="form-floating">
                                <input className="form-control email" type="email" name="email" placeholder="name@gmail.com" value={form.email} onChange={this.handleChange}/>
                                <label>Email address</label>
                            </div>
                            <div className="form-floating">
                                <input className="form-control password" type="password" name="password" placeholder="Password" value="{form.password" onChange={this.handleChange}/>
                                <label>Password</label>
                            </div>
                            <div className="checkbox mb-3">
                              <label>
                                    <input type="checkbox" value={form.isRemember} onChange={this.handleChangeCheckbox}/>Remember me
                              </label>
                            </div>
                              <button className="w-100 btn btn-lg btn-primary" type="button" onClick={this.handleSubmit}>Sign in</button>
                    </form>
                </div>
            </div>
        );
    }
}

    export default Bootstrap;
