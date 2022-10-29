import {User} from './user';
import {InformationSheet} from './information-sheet';
import {Car} from '../../car/models/car';
import {District} from './district';

export interface Customer {
  id?: number;
  name?: string;
  gender?: string;
  address?: string;
  firstPhoneNumber?: string;
  secondPhoneNumber?: string;
  dateOfBirth?: string;
  email?: string;
  occupation?: string;
  salesMethod?: string;
  paymentMethod?: string;
  informationSource?: string;
  createDate?: string;
  updateDate?: string;
  customerStatus?: string;
  car?: Car;
  district?: District;
  deleteStatus?: number;
  user: User;
  informationSheets: InformationSheet [];
}
