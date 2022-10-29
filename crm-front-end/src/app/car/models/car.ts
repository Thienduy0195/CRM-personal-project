import {CarLabel} from './carLabel';
import {Customer} from '../../customer/models/customer';

export interface Car {
  id: number;
  name?: string;
  price?: string;
  amount?: string;
  yearOfManufacture?: string;
  carLabel: CarLabel;
  customerList: Customer [];
}
