# JAVA CHAT APPLICATION

An simple chat application using Java's network programming. This project enables the user to send and receive messages over local network using UDP protocol.


# Requirements 
- Java JDK installed environment
- Local internet connection

## How to Use

1. Clone this repo into your local machine.
2. Navigate to the main directory of the local repo.
3. Compile the Sendr and Receve program in the directory terminal.
> Use ```javac Sendr.java``` ```javac Receve.java``` commands
4. Then run the Sendr and Receve application to Send and Receive messages.

## How to check IP address
>Terminal commands
- For Ubuntu, use ``hostname -I``
- For Debian based distro ```nmcli -p device show```
- For Windows ```ipconfig```
- For Mac OS ```ipconfig getifaddr en0``` or ``ifconfig``


## Note
- Since this project is based on data transfer on UDP method, hence the messages are transferred **only when both the sender and receiver are connected to the same network**
 - Ensure that both the system's firewall rules allows incoming and outgoing UDP packets
