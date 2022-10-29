import {Customer} from './customer';

export interface District {
  id: number;
  name: string;
  customerList: Customer [];
}
