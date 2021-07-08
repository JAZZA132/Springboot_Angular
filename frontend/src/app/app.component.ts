import { Component } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'grokonez';
  description = 'Angular-WebSocket Demo';

  greetings: string[] = [];
  disabled = true;
  name: string | undefined;
  private stompClient = new Stomp.Client;
  
  constructor() { }

  
  setConnected(connected: boolean) {
    this.disabled = !connected;

    if (connected) {
      this.greetings = [];
    }
  }

  connect() {
    const socket = new SockJS('http://localhost:8080/gkz-stomp-endpoint');
    this.stompClient = Stomp.over(socket);

    const _this = this;
    this.stompClient.connect({}, function (frame) {
      _this.setConnected(true);
      console.log('Connected: ' + frame);

      _this.stompClient.subscribe('/topic/hi', function (hello) {
        _this.showGreeting(JSON.parse(hello.body).greeting);
      });
    });
  }

  disconnect() {
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }

    this.setConnected(false);
    console.log('Disconnected!');
  }

  sendName() {
    this.stompClient.send(
      '/gkz/hello',
      {},
      JSON.stringify({ 'name': this.name })
    );
  }

  showGreeting(message: any) {
    this.greetings.push(message);
  }

}
// export class AppComponent implements OnInit, OnDestroy {
//   constructor(private wsService: WebSocketService) { }
//   ngOnDestroy() {
//     this.wsService.closeWebSocket();
//   }
//   ngOnInit() {
//     this.wsService.createObservableSocket('ws://localhost:8080/gkz-stomp-endpoint')
//       .subscribe(
//         data => console.log(data),
//         err => console.log(err),
//         () => console.log('流已经结束')
//       );
//     }


// }