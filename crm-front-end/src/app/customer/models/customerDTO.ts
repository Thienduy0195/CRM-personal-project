import {Car} from '../../car/models/car';
import {User} from './user';

export interface CustomerDTO {
  id?: number;
  name?: string;
  firstPhoneNumber?: string;
  secondPhoneNumber?: string;
  dateOfBirth?: string;
  gender?: string;
  address?: string;
  email?: string;
  occupation?: string;
  salesMethod?: string;
  paymentMethod?: string;
  informationSource?: string;
  createDate?: string;
  updateDate?: string;
  car: Car;
  carColor?: string;
  yearOfManufacture?: string;
  content: string;
  customerStatus?: string;
  deleteStatus?: number;
  user: User;
}
