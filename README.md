# nls

NLS Scan plugin project.

  static const EventChannel _eventChannel = EventChannel('nlsresult');
  StreamSubscription? _streamSubscription;

  @override
  void initState() {
    super.initState();
    _streamSubscription =
        _eventChannel.receiveBroadcastStream().listen((value) {
      try {
        print(value);
      } catch (e, s) {
        print(e);
        print(s);
      }
    });
  }