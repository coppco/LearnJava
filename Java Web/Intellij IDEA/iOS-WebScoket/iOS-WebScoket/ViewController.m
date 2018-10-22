//
//  ViewController.m
//  iOS-WebScoket
//
//  Created by apple on 2018/6/16.
//  Copyright © 2018年 apple. All rights reserved.
//

#import "ViewController.h"
#import <SocketRocket.h>

@interface ViewController ()<SRWebSocketDelegate, UITableViewDelegate, UITableViewDataSource>
/**
 webSocket
 */
@property(nonatomic, strong)SRWebSocket *webSocket;
/**
 显示消息
 */
@property(nonatomic, strong)UITableView *tableView;
/**
 消息
 */
@property(nonatomic, strong)NSMutableArray *messages;
/**
 发送消息
 */
@property(nonatomic, strong)UITextField *messageTF;
@end

@implementation ViewController

- (void)viewDidLoad {
    self.navigationItem.title = @"使用SocketRocket";
    [super viewDidLoad];
    [self.view addSubview:self.tableView];
    [self.webSocket open];
    
}

- (SRWebSocket *)webSocket {
    if (!_webSocket) {
        _webSocket = ({
            NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:@"ws://114.55.27.208:8800"]];
            SRWebSocket *object = [[SRWebSocket alloc] initWithURLRequest:request];

            object.delegate = self;
            object;
        });
    }
    return _webSocket;
}

- (UITableView *)tableView {
    if (!_tableView) {
        _tableView = ({
            UITableView *object = [[UITableView alloc] initWithFrame:self.view.bounds style:(UITableViewStylePlain)];
            [object registerClass:[UITableViewCell class] forCellReuseIdentifier:@"cell"];
            object.tableFooterView = [UIView new];
            object.delegate = self;
            object.dataSource = self;
            object;
        });
    }
    return _tableView;
}
- (NSMutableArray *)messages {
    if (!_messages) {
        _messages = ({
            NSMutableArray *object = [[NSMutableArray alloc] init];
            object;
        });
    }
    return _messages;
}

- (UITextField *)messageTF {
    if (!_messageTF) {
        _messageTF = ({
            UITextField *object = [[UITextField alloc] init];
            object.tintColor = [UIColor blueColor];
            object.borderStyle = UITextBorderStyleRoundedRect;
            object.placeholder = @"请输入发送内容";
            object.textColor = [UIColor blackColor];
            object.font = [UIFont systemFontOfSize:16];
            UIButton *rightView = [UIButton buttonWithType:(UIButtonTypeCustom)];
            [rightView addTarget:self action:@selector(sendMessage) forControlEvents:(UIControlEventTouchUpInside)];
            [rightView setTitle:@"   发送   " forState:(UIControlStateNormal)];
            [rightView setTitleColor:[UIColor orangeColor] forState:(UIControlStateNormal)];
            [rightView sizeToFit];
            object.rightView = rightView;
            object.rightViewMode = UITextFieldViewModeAlways;
            object;
        });
    }
    return _messageTF;
}
- (void)sendMessage {
//    [self.webSocket send:self.messageTF.text ? : @"iOS"];
    
    NSDictionary *dic = @{
                                        @"type":@"2",
                                        @"data":@[@{
                                                @"b_coin":@"bch",
                                                @"v_coin": @"usdt",
                                                @"periods":@"1min",
                                                @"data_type":@"0"
                                                }]};
    
    NSData *data = [NSJSONSerialization dataWithJSONObject:dic options:0 error:nil];
    
    NSString *json = [[NSString alloc] initWithData:data encoding:(NSUTF8StringEncoding)];
    NSLog(@"%@", json);
    
    [self.webSocket send:json];
}

#pragma - mark UITableViewDelegate, UITableViewDataSource
- (CGFloat)tableView:(UITableView *)tableView heightForHeaderInSection:(NSInteger)section {
    return 40;
}
- (UIView *)tableView:(UITableView *)tableView viewForHeaderInSection:(NSInteger)section {
    return self.messageTF;
}
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"cell" forIndexPath:indexPath];
    cell.textLabel.text = self.messages[indexPath.row];
    return cell;
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.messages.count;
}

#pragma - mark SRWebSocketDelegate

/**
 接收到消息
 */

- (void)webSocket:(SRWebSocket *)webSocket didReceiveMessage:(id)message {
    NSError *error = nil;
    id value = [NSJSONSerialization JSONObjectWithData:message options:(NSJSONReadingAllowFragments) error:&error];
    NSLog(@"%@", value);
}

/**
 连接时
 */
- (void)webSocketDidOpen:(SRWebSocket *)webSocket {
    [self.messages addObject:@"连接WebSocket成功"];
    [self reload];
}

/**
 连接失败时
 */
- (void)webSocket:(SRWebSocket *)webSocket didFailWithError:(NSError *)error {
    [self.messages addObject:@"连接WebSocket失败"];
    [self reload];
}

/**
 关闭时
 */
- (void)webSocket:(SRWebSocket *)webSocket didCloseWithCode:(NSInteger)code reason:(NSString *)reason wasClean:(BOOL)wasClean {
    [self.messages addObject:@"关闭WebSocket连接"];
    [self reload];
}

/**
 接收到服务器的Pong时调用, 一般用作心跳
 */
- (void)webSocket:(SRWebSocket *)webSocket didReceivePong:(NSData *)pongPayload {
    [self.messages addObject:@"收到心跳包"];
    [self reload];
}
/**
 是否把 NSData 转成 NSString, 默认YES
 */
- (BOOL)webSocketShouldConvertTextFrameToString:(SRWebSocket *)webSocket {
    return NO;
}

- (void)reload {
    [self.tableView reloadData];
}

@end
