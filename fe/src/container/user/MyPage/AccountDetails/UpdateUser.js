import axios from 'axios'
import React, { useEffect, useState } from 'react' 
const btnStyle={width:150, margin: '0 auto'}
const blackBorder = {border: "1px solid black"}
const UpdateUser = (props) => {
    const [ user, setUser ] = useState({})
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [email, setEmail] = useState('')
    const [phoneNumber, setPhoneNumber] = useState('')
    const [preferGenre, setPreferGenre] = useState('')
    const editUser = () => {
        setUser(JSON.parse(localStorage.getItem("user")))
    } 
    const URL = `http://localhost:8080/users/`
    const userEdit = e => {
        e.preventDefault()
        axios({
            url: URL+user.userNum,
            method: 'put',
            headers: {'Content-Type':'application/json','Authorization': 'Bearer '+localStorage.getItem("token")},
            data: {userNum: user.userNum, username, password, name: user.name, email, gender:user.gender, birthday:user.birthday, phoneNumber, admin:user.admin, preferGenre}
        }).then(res => {
            props.history.push('/profile')
        }).catch(err => {
            alert(err)
        })
    }
    const userDelete = e => {
        e.preventDefault()
        axios({
            url: URL+user.userNum,
            method: 'delete',
            headers: {'Content-Type':'application/json','Authorization': 'Bearer '+localStorage.getItem("token")},
            data: {}
        }).then(res => {
            props.history.push('/')
        }).catch(err => {
            alert(err)
        })
    }
    useEffect(()=>editUser(), [])
    return (<>
    <div style={{width:500, margin: "0 auto"}}>
        <h3>회원정보 수정하기</h3>
        <table style={blackBorder}>
            <tr style={blackBorder}>
                <td style={blackBorder}>회원번호</td>
                <td style={blackBorder}>아이디</td>
                <td style={blackBorder}>비밀번호</td>
                <td style={blackBorder}>이름</td>
                <td style={blackBorder}>이메일</td>
                <td style={blackBorder}>성별</td>
                <td style={blackBorder}>생년월일</td>
                <td style={blackBorder}>전화번호</td>
                <td style={blackBorder}>관리자</td>
                <td style={blackBorder}>선호장르</td>
                </tr>
            <tr style={blackBorder}>
                <td style={blackBorder}>{user.userNum}</td>
                <td style={blackBorder}><input className="box" type="text" onChange={e => setUsername(e.target.value)}/></td>
                <td style={blackBorder}><input className="box" type="text" onChange={e => setPassword(e.target.value)}/></td>
                <td style={blackBorder}>{user.name}</td>
                <td style={blackBorder}><input className="box" type="text" onChange={e => setEmail(e.target.value)}/></td>
                <td style={blackBorder}>{user.gender}</td>
                <td style={blackBorder}>{user.birthday}</td>
                <td style={blackBorder}><input className="box" type="text" onChange={e => setPhoneNumber(e.target.value)}/></td>
                <td style={blackBorder}>{user.admin}</td>
                <td style={blackBorder}><input className="box" type="text" onChange={e => setPreferGenre(e.target.value)}/></td>

                </tr> 
            <tr>
            <td style={blackBorder} colSpan={2}><button style={btnStyle} onClick={userEdit} >수 정</button></td>
                <td style={blackBorder} colSpan={2}><button style={btnStyle} onClick={()=>{props.history.push(`/profile`)}}>취 소</button></td>
                <td style={blackBorder} colSpan={2}><button style={btnStyle} onClick={userDelete}>회원탈퇴</button></td>
                </tr>
        </table>
        </div>
        </>)
}

export default UpdateUser