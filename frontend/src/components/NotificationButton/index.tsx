import axios from 'axios';
import icon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './style.css'

type Props={
    saleId:number;
}
function handleClick(id:number){

axios(`${BASE_URL}/sales/${id}/notification`)
    .then(response=>{
        console.log("sucesso");
    })



}
function NotificationButon({saleId}:Props) {
  return( 
        
    <div className="dsmeta-red-btn" onClick={() => {handleClick(saleId)}}>
        <img src={icon} alt="Notificar" />
    </div>
    
    );
}
export  default NotificationButon;
