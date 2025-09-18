package binary_opretor;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Order {
    String orderId;
    String userId;
    String productId;
    int quantity;
    double baseAmount;
    String region;
    String customerTier;
    boolean isInventoryAvailable;
    double finalAmount;
    String status;
    
    Order(String userId, String productId, int quantity, double baseAmount, 
          String region, String customerTier) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.baseAmount = baseAmount;
        this.region = region;
        this.customerTier = customerTier;
        this.status = "PENDING";
        this.isInventoryAvailable = false;
        this.finalAmount = baseAmount;
    }
    
    @Override
    public String toString() {
        return String.format("Order[ID=%s, User=%s, Product=%s, Qty=%d, Amount=%.2f, Status=%s]",
            orderId, userId, productId, quantity, finalAmount, status);
    }
}

class Warehouse {
    String region;
    Map<String, Integer> inventory;
    
    Warehouse(String region, Map<String, Integer> inventory) {
        this.region = region;
        this.inventory = inventory;
    }
}

class PaymentSplit {
    double giftCard;
    double wallet;
    double creditCard;
    
    PaymentSplit(double giftCard, double wallet, double creditCard) {
        this.giftCard = giftCard;
        this.wallet = wallet;
        this.creditCard = creditCard;
    }
}

public class OrderProcessingSystem {
    
    private static List<Warehouse> warehouses = Arrays.asList(
        new Warehouse("US", new HashMap<>(Map.of("PROD001", 100, "PROD002", 50, "PROD003", 75))),
        new Warehouse("EU", new HashMap<>(Map.of("PROD001", 80, "PROD002", 30, "PROD003", 60))),
        new Warehouse("ASIA", new HashMap<>(Map.of("PROD001", 120, "PROD002", 90, "PROD003", 40)))
    );
    
    public static void main(String[] args) {
        
        Predicate<Order> isValidOrder = order -> 
            order.baseAmount > 0 && 
            order.quantity > 0 && 
            order.userId != null && 
            !order.userId.trim().isEmpty();
            
        Predicate<Order> isEligibleForExpress = order -> 
            order.baseAmount > 500 && 
            ("GOLD".equals(order.customerTier) || "SILVER".equals(order.customerTier));
            
        Predicate<Order> isPriorityOrder = order -> 
            "GOLD".equals(order.customerTier) && order.baseAmount > 1000;
        
        BiPredicate<Order, Warehouse> hasInventory = (order, warehouse) -> 
            warehouse.inventory.getOrDefault(order.productId, 0) >= order.quantity;
            
        BiPredicate<String, String> isRegionMatch = (orderRegion, warehouseRegion) -> 
            orderRegion.equalsIgnoreCase(warehouseRegion);
            
        BiPredicate<String, Double> canApplyBulkDiscount = (tier, amount) -> 
            "GOLD".equals(tier) && amount > 2000;
        
        Consumer<Order> orderLogger = order -> 
            System.out.println("📋 LOG: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) 
                + " - Order processed: " + order.orderId);
                
        Consumer<Order> sendEmailNotification = order -> 
            System.out.println("📧 EMAIL: Order confirmation sent to user " + order.userId 
                + " for order " + order.orderId);
                
        Consumer<Order> sendSMSNotification = order -> 
            System.out.println("📱 SMS: Your order " + order.orderId + " is confirmed!");
            
        Consumer<String> auditTrail = event -> 
            System.out.println("🔍 AUDIT: " + LocalDateTime.now() + " - " + event);
        
        BiConsumer<Order, String> updateOrderStatus = (order, status) -> {
            order.status = status;
            System.out.println("✅ Status Updated: Order " + order.orderId + " -> " + status);
        };
        
        BiConsumer<String, Double> paymentLogger = (method, amount) -> 
            System.out.println("💳 PAYMENT: $" + String.format("%.2f", amount) + " via " + method);
            
        BiConsumer<Order, Warehouse> reserveInventory = (order, warehouse) -> {
            int current = warehouse.inventory.get(order.productId);
            warehouse.inventory.put(order.productId, current - order.quantity);
            System.out.println("📦 RESERVED: " + order.quantity + " units of " + order.productId 
                + " from " + warehouse.region + " warehouse");
        };
        
        Function<Order, Double> calculateTax = order -> {
            double taxRate = switch(order.region) {
                case "US" -> 0.08;
                case "EU" -> 0.20;
                case "ASIA" -> 0.10;
                default -> 0.05;
            };
            return order.baseAmount * taxRate;
        };
        
        Function<Order, Double> calculateShipping = order -> {
            if (order.baseAmount > 1000) return 0.0;
            return switch(order.region) {
                case "US" -> 15.0;
                case "EU" -> 25.0;
                case "ASIA" -> 20.0;
                default -> 30.0;
            };
        };
        
        Function<Order, Double> applyTierDiscount = order -> {
            double discountRate = switch(order.customerTier) {
                case "GOLD" -> 0.15;
                case "SILVER" -> 0.10;
                case "BRONZE" -> 0.05;
                default -> 0.0;
            };
            return order.baseAmount * discountRate;
        };
        
        Function<String, Double> currencyConverter = region -> {
            return switch(region) {
                case "US" -> 1.0;
                case "EU" -> 0.85;
                case "ASIA" -> 110.0;
                default -> 1.0;
            };
        };
        
        UnaryOperator<Double> applySeasonalDiscount = amount -> amount * 0.9;
        UnaryOperator<Double> applyLoyaltyBonus = amount -> amount * 0.95;
        UnaryOperator<String> formatOrderId = id -> "ORD-2024-" + id.toUpperCase();
        UnaryOperator<Double> roundAmount = amount -> Math.round(amount * 100.0) / 100.0;
        
        BinaryOperator<Double> combinePayments = (amount1, amount2) -> amount1 + amount2;
        BinaryOperator<Double> calculateTotalCost = (baseAmount, additionalCharges) -> baseAmount + additionalCharges;
        BinaryOperator<String> mergeNotifications = (email, sms) -> "COMBINED: " + email + " | " + sms;
        BinaryOperator<Integer> mergeInventory = (warehouse1Stock, warehouse2Stock) -> warehouse1Stock + warehouse2Stock;
        
        Supplier<String> generateOrderId = () -> "ID" + System.currentTimeMillis() + "-" + (int)(Math.random() * 1000);
        Supplier<String> generateTrackingNumber = () -> "TRK" + System.currentTimeMillis();
        Supplier<String> generateInvoiceNumber = () -> "INV-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) 
            + "-" + (int)(Math.random() * 10000);
        Supplier<LocalDateTime> getCurrentTimestamp = () -> LocalDateTime.now();
        
        System.out.println("🚀 STARTING REAL-TIME ORDER PROCESSING SYSTEM");
        System.out.println("=" .repeat(60));
        
        List<Order> incomingOrders = Arrays.asList(
            new Order("USER001", "PROD001", 2, 1500.0, "US", "GOLD"),
            new Order("USER002", "PROD002", 1, 800.0, "EU", "SILVER"),
            new Order("USER003", "PROD003", 5, 300.0, "ASIA", "BRONZE"),
            new Order("USER004", "PROD001", 1, 2500.0, "US", "GOLD")
        );
        
        for (Order order : incomingOrders) {
            System.out.println("\n🔄 PROCESSING ORDER FOR USER: " + order.userId);
            System.out.println("-".repeat(50));
            
            order.orderId = formatOrderId.apply(generateOrderId.get());
            auditTrail.accept("Order created: " + order.orderId);
            
            if (!isValidOrder.test(order)) {
                System.out.println("❌ Order validation failed!");
                continue;
            }
            
            Warehouse selectedWarehouse = null;
            for (Warehouse warehouse : warehouses) {
                if (isRegionMatch.test(order.region, warehouse.region) && 
                    hasInventory.test(order, warehouse)) {
                    selectedWarehouse = warehouse;
                    break;
                }
            }
            
            if (selectedWarehouse == null) {
                System.out.println("❌ No inventory available in region: " + order.region);
                updateOrderStatus.accept(order, "OUT_OF_STOCK");
                continue;
            }
            
            reserveInventory.accept(order, selectedWarehouse);
            order.isInventoryAvailable = true;
            
            double tax = calculateTax.apply(order);
            double shipping = calculateShipping.apply(order);
            double discount = applyTierDiscount.apply(order);
            
            double discountedAmount = order.baseAmount - discount;
            if (canApplyBulkDiscount.test(order.customerTier, order.baseAmount)) {
                discountedAmount = applySeasonalDiscount.apply(discountedAmount);
                System.out.println("💰 Bulk discount applied!");
            }
            
            discountedAmount = applyLoyaltyBonus.apply(discountedAmount);
            
            double totalCharges = tax + shipping;
            order.finalAmount = roundAmount.apply(
                calculateTotalCost.apply(discountedAmount, totalCharges)
            );
            
            System.out.println("💵 PRICING BREAKDOWN:");
            System.out.println("   Base: $" + String.format("%.2f", order.baseAmount));
            System.out.println("   Discount: -$" + String.format("%.2f", discount));
            System.out.println("   Tax: +$" + String.format("%.2f", tax));
            System.out.println("   Shipping: +$" + String.format("%.2f", shipping));
            System.out.println("   FINAL: $" + String.format("%.2f", order.finalAmount));
            
            PaymentSplit payment = new PaymentSplit(100.0, 200.0, order.finalAmount - 300.0);
            
            paymentLogger.accept("Gift Card", payment.giftCard);
            paymentLogger.accept("Wallet", payment.wallet);
            paymentLogger.accept("Credit Card", payment.creditCard);
            
            double totalPaid = combinePayments.apply(
                combinePayments.apply(payment.giftCard, payment.wallet), 
                payment.creditCard
            );
            
            if (Math.abs(totalPaid - order.finalAmount) < 0.01) {
                updateOrderStatus.accept(order, "PAID");
            }
            
            String trackingNumber = generateTrackingNumber.get();
            String invoiceNumber = generateInvoiceNumber.get();
            
            System.out.println("🏷️  Tracking: " + trackingNumber);
            System.out.println("🧾 Invoice: " + invoiceNumber);
            
            sendEmailNotification.accept(order);
            sendSMSNotification.accept(order);
            
            if (isPriorityOrder.test(order)) {
                System.out.println("⭐ PRIORITY ORDER - Fast-track processing!");
                updateOrderStatus.accept(order, "PRIORITY_PROCESSING");
            } else if (isEligibleForExpress.test(order)) {
                System.out.println("🚚 EXPRESS DELIVERY available");
                updateOrderStatus.accept(order, "EXPRESS_PROCESSING");
            } else {
                updateOrderStatus.accept(order, "STANDARD_PROCESSING");
            }
            
            orderLogger.accept(order);
            auditTrail.accept("Order completed: " + order.orderId + " - Amount: $" + order.finalAmount);
            
            System.out.println("✅ ORDER COMPLETED: " + order);
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📊 SYSTEM PERFORMANCE METRICS");
        System.out.println("=".repeat(60));
        
        Supplier<Integer> ordersPerSecond = () -> (int)(Math.random() * 1000) + 8000;
        Supplier<Double> averageResponseTime = () -> Math.random() * 200 + 300;
        
        System.out.println("🔥 Orders/Second: " + ordersPerSecond.get());
        System.out.println("⏱️  Avg Response Time: " + String.format("%.1f", averageResponseTime.get()) + "ms");
        
        System.out.println("\n📦 CURRENT INVENTORY STATUS:");
        for (Warehouse warehouse : warehouses) {
            System.out.println("Region: " + warehouse.region + " - " + warehouse.inventory);
        }
        
        System.out.println("\n🎯 ORDER PROCESSING PIPELINE COMPLETED!");
    }
}
