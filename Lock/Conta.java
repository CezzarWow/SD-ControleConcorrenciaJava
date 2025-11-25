import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private double saldo = 0;
    private Lock lock = new ReentrantLock();
    
    // Construtor vazio para permitir new Conta()
    public Conta() {
        this.saldo = 0;
        System.out.println("Conta criada. Saldo inicial: R$" + this.saldo);
    }

    // Construtor com saldo inicial
    public Conta(double saldo) {
        this.saldo = saldo;
        System.out.println("Conta criada. Saldo inicial: R$" + saldo);
    }
    
    public double getSaldo() {
        lock.lock();
        try {
            return saldo;
        } finally {
            lock.unlock();
        }
    }
    
    public void setSaldo(double saldo) {
        lock.lock();
        try {
            this.saldo = saldo;
        } finally {
            lock.unlock();
        }
    }
    
    public double debitarValor(double valor) {
        lock.lock();
        try {
            if (this.saldo < valor) {
                System.out.println("Saldo insuficiente para saque para " + Thread.currentThread().getName());
                return -1;
            } else {
                this.saldo -= valor;
                System.out.println("Cliente " + Thread.currentThread().getName() + " ativo. Saque no valor R$ " + valor + " realizado com sucesso!");
                return this.saldo;
            }
        } finally {
            lock.unlock();
        }
    }
}
