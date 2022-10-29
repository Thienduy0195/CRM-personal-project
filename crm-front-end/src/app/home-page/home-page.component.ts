import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private toastr: ToastrService) {
  }

  currentHours: string;
  currentMinutes: string;
  currentDay: string;
  currentMonth: string;
  currentYear: string;
  dayName: string;

  ngOnInit(): void {
    // this.toastr.success('Welcome to CRM Application!', 'HOME PAGE');
    this.updateCurrentTime();
  }

  updateCurrentTime() {
    this.getCurrentTime();
  }

  getCurrentTime(): void {
    const date = new Date();
    const currentDayInWeek = date.getDay();
    switch (currentDayInWeek) {
      case 0:
        this.dayName = 'SUN';
        break;
      case 1:
        this.dayName = 'MON';
        break;
      case 2:
        this.dayName = 'TUE';
        break;
      case 3:
        this.dayName = 'WED';
        break;
      case 4:
        this.dayName = 'THU';
        break;
      case 5:
        this.dayName = 'FRI';
        break;
      case 6:
        this.dayName = 'SAT';
    }
    this.currentHours = date.getHours() > 9 ? date.getHours().toString() : '0' + date.getHours().toString();
    this.currentMinutes = date.getMinutes() > 9 ? date.getMinutes().toString() : '0' + date.getMinutes().toString();
    this.currentDay = date.getDate() > 9 ? date.getDate().toString() : '0' + date.getDate().toString();
    this.currentMonth = date.getMonth() > 8 ? (date.getMonth() + 1).toString() : '0' + (date.getMonth() + 1).toString();
    this.currentYear = date.getFullYear().toString().substring(2);
  }

}
